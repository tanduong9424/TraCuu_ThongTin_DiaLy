/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DoAnUngDungMang;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author DELL
 */
public class Server {
    private int port;
    private int bufferSize;
    private DatagramPacket receivePacket;
    
    /**
     * @param args the command line arguments
     */
     public Server(int port, int bufferSize) {
        this.port = port;
        this.bufferSize = bufferSize;
    }
     public void start(){
        try(DatagramSocket socket = new DatagramSocket(port)){
            while(true){
                String receivedData = receivedData(socket);
                System.out.println("Server nhận: " + receivedData);
                
                sendData(socket, receivedData);
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    private  String xulyInput(String input){
        /*if(input.toLowerCase().startsWith("weather ")){// tra cứu thời tiết 
            return processData1(input.substring("weather ".length()).trim());
        }
            
        else if(input.toLowerCase().startsWith("convert ")){//chuyển đổi cơ số 
            String tmp = input.substring("convert ".length()).trim();
            String [] parts =tmp.split(" ");
            return processData2(parts[0], parts[1], parts[2]);  
        }
        //trường hợp nhập lỗi 
        return "Lỗi tra cứu vui lòng nhập lại";*/
        return processData1(input);
    }
    
        // Xử lý dữ liệu khi tra cứu thời tiết 
    private String processData1(String input) {
        String result="";
        String apiKey = "BxxuJ27iisBeN6pLqQW6nQvGorfMJd3m";             
        String url = "https://api.tomorrow.io/v4/weather/realtime?apikey="+apiKey;
        try{
            Document doc = Jsoup.connect(url) // kết nối đến API
                    .method(Connection.Method.GET) // với phương thức GET
                    //.header("apikey", apiKey)// bỏ API key vào
                    .data("location", input) //bỏ luôn cái location vào, khỏi encoding
                    .ignoreContentType(true) // sử dụng trong trường hợp dữ liệu trả về là JSON
                    .execute() // thực thi request
                    .parse(); // Chuyển dữ liệu của request từ dạng Response -> Document
            
            JSONObject json = new JSONObject(doc.text());

            JSONObject data = json.getJSONObject("data");
            JSONObject values = data.getJSONObject("values");
            JSONObject location = json.getJSONObject("location");
            
            double temperature = values.getDouble("temperature");//nhiệt độ
            String time=data.getString("time");//thời gian
            String tendialy = location.getString("name");//địa chỉ lấy
            Integer uv=values.getInt("uvIndex");//lấy chỉ số uv
            Integer humidity=values.getInt("humidity");//lấy độ ẩm
            
            double kinhdo=location.getDouble("lon");//longitude 
            //kinhdo = Math.round(kinhdo * 100.0) / 100.0;// Làm tròn đến 3 chữ số thập phân

            double vido=location.getDouble("lat");//latitude 
            //vido = Math.round(vido * 100.0) / 100.0;// Làm tròn đến 3 chữ số thập phân
            
            result+=tendialy+"/"+time+"/"+uv+"/"+temperature+"/"+humidity+"/"+kinhdo+"/"+vido;

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }

    private String processData2(String from, String to ,String input) {
        String result="";        
        String url = "https://networkcalc.com/api/binary/"+input;
        try{
            Document doc = Jsoup.connect(url) // kết nối đến API
                    .method(Connection.Method.GET) // với phương thức GET
                    .data("from", from)
                    .data("to",to)
                    .ignoreContentType(true) // sử dụng trong trường hợp dữ liệu trả về là JSON
                    .execute() // thực thi request
                    .parse(); // Chuyển dữ liệu của request từ dạng Response -> Document
            
            JSONObject json = new JSONObject(doc.text());

            String cosoFrom = json.getString("from");
            String cosoTo = json.getString("to");
            String ketqua = json.getString("converted");
            
            result = "Kết quả đổi "+ input +"từ cơ số "+ from + " sang cơ số "+ to +": "+ketqua;

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    private String receivedData(DatagramSocket socket) throws IOException {
        receivePacket = new DatagramPacket(new byte[bufferSize], bufferSize);
        socket.receive(receivePacket);
        byte[] receivedBytes = Arrays.copyOf(receivePacket.getData(), receivePacket.getLength());
        return new String(receivedBytes, StandardCharsets.UTF_8);
    }

    private void sendData(DatagramSocket socket, String receivedData) throws IOException {
        String response=xulyInput(receivedData);//dữ liệu gửi đi được lấy ra ở đây 
        byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(responseBytes, responseBytes.length, receivePacket.getAddress(), receivePacket.getPort());
        socket.send(packet);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Server server = new Server(1234, 1024);
        server.start();
    }
    
}
