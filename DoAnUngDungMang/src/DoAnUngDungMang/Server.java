/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DoAnUngDungMang;
import DoAnUngDungMang.SearchHotel;
import static DoAnUngDungMang.test.getAddressFromCoordinates;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.table.DefaultTableModel;
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
        /*if(input.toLowerCase().startsWith("location/")){// tra cứu thời tiết 
            return processData1(input.substring("location/".length()).trim());
        }
            
        else if(input.toLowerCase().startsWith("hotel/")){//chuyển đổi cơ số 
            return processData2(parts[0], parts[1], parts[2]);
            String date=input.substring("hotel/".length()).trim();
            String [] parts =date.split("/");
            
            return processData2(parts[0], parts[1]);
        }*/
        //trường hợp nhập lỗi 
        //return "Lỗi tra cứu vui lòng nhập lại";
        return processData1(input.toLowerCase());
        
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
            double kinhdo1 = Math.round(kinhdo * 100.0) / 100.0;// Làm tròn đến 3 chữ số thập phân

            double vido=location.getDouble("lat");//latitude 
            double vido1 = Math.round(vido * 100.0) / 100.0;// Làm tròn đến 3 chữ số thập phân
            
      
            //String khachsan=processData2(kinhdo,vido);
           
            result+=tendialy+"//"+time+"//"+uv+"//"+temperature+"//"+humidity+"//"+kinhdo1+"//"+vido1;//+khachsan;

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }

    private String processData2(double kinhdo, double vido) throws IOException, InterruptedException {
      LocalDate currentDate = LocalDate.now();
      LocalDate tomorrow = currentDate.plusDays(1);// Lấy ngày mai (ngày hiện tại + 1 ngày)
      String ketqua="";
      HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates?"+
                        "latitude="+vido
                        +"&longitude="+kinhdo//SỬA KINH ĐỘ VĨ ĐỘ ĐỂ TRA CỨU, LẤY TỪ BÊN TRA CỨU THỜI TIẾT :V
                        +"&arrival_date="+currentDate
                        +"&departure_date="+tomorrow
                        //+ "&adults=1"
                        //+ "&children_age=0%2C17"
                        + "&room_qty=1"
                        + "&units=metric&page_number=1"
                        + "&temperature_unit=c"
                        + "&languagecode=en-us"
                        + "&currency_code=EUR"
                        + "&location=US"))
               
              
                .header("x-rapidapi-key", "b9573d7cadmshc45692d23865c48p1f4603jsnb4bcb77dc1bd")
		.header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
      
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String jsonData=response.body();
             JSONObject jsonObject = new JSONObject(jsonData);
            //System.out.println(response.body());

         if (jsonObject.getBoolean("status")) {
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray results = data.getJSONArray("result");
            
            
            //SearchHotel x=new SearchHotel();
            //x.setVisible(true);
               
               
            // Duyệt qua mảng "result"
            for (int i = 0; i < results.length(); i++) {
                JSONObject hotel = results.getJSONObject(i);//duyệt danh sách khách sạn

                String hotelName = hotel.getString("hotel_name");//lấy ra 1
                
                JSONObject composite_price_breakdown=hotel.getJSONObject("composite_price_breakdown");
                JSONObject all_inclusive_amount_hotel_currency=composite_price_breakdown.getJSONObject("all_inclusive_amount_hotel_currency");
                Integer price =all_inclusive_amount_hotel_currency.getInt("value");
                String currency=all_inclusive_amount_hotel_currency.getString("currency");
                String PriceHotel =price+" "+currency;//lấy ra 2 
                
                double reivew=hotel.getDouble("review_score");//lấy ra 3
                
                double longitude=hotel.getDouble("longitude");//tung do
                double latitude=hotel.getDouble("latitude");//vido
                String address = getAddressFromCoordinates(latitude, longitude);//lấy ra 4

               /* System.out.println("Hotel Name: " + hotelName);
                System.out.println("Price: " + price+" "+currency);
                System.out.println("Review: " + reivew);
                //System.out.println("Tung độ "+longitude);
                //System.out.println("Vĩ độ "+latitude);
                System.out.println("Địa chỉ "+address);
                System.out.println("----------------------------------------");*/
                
                ketqua+="-"+hotelName+"/"+PriceHotel+"/"+reivew+"/"+address+"?";
                //Object[] row = {hotelName,PriceHotel,reivew,address};
                //x.updateDatatable(row);
                
            }
        } 
        else {
            System.out.println("Lỗi: " + jsonObject.getString("message"));
        }
        return ketqua;
    }

    
    private String receivedData(DatagramSocket socket) throws IOException {
        receivePacket = new DatagramPacket(new byte[bufferSize], bufferSize);
        socket.receive(receivePacket);
        byte[] receivedBytes = Arrays.copyOf(receivePacket.getData(), receivePacket.getLength());
        return new String(receivedBytes, StandardCharsets.UTF_8);
    }

    private void sendData(DatagramSocket socket, String receivedData) throws IOException {
        String response=xulyInput(receivedData);//dữ liệu gửi đi được lấy ra ở đây 
        System.out.println("Du lieu gui "+response);
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
