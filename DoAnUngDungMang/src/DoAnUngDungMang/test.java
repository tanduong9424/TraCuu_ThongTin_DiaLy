/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAnUngDungMang;
import static ReverseGeocoding.getAddressFromCoordinates;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import org.json.JSONObject;
import org.json.JSONArray;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class test {
    public static String getAddressFromCoordinates(double latitude, double longitude) {
         String apiUrl = String.format("https://nominatim.openstreetmap.org/reverse?lat=%f&lon=%f&format=json", latitude, longitude);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();

                // Sử dụng thư viện Gson để phân tích JSON
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);

                if (jsonObject != null && jsonObject.has("address")) {
                    JsonObject address = jsonObject.getAsJsonObject("address");

                    String road = address.has("road") ? address.get("road").getAsString() : "";
                    String suburb = address.has("suburb") ? address.get("suburb").getAsString() : "";
                    String city = address.has("city") ? address.get("city").getAsString() : "";
                    String state = address.has("state") ? address.get("state").getAsString() : "";
                    String country = address.has("country") ? address.get("country").getAsString() : "";

                    String result = road + " " + suburb + " " + city + " " + state + " " + country;
                    return result;
                } else {
                    return null; // Không tìm thấy địa chỉ
                }
            } else {
                System.err.println("Lỗi HTTP: " + response.statusCode());
                return null; // Lỗi khi gọi API
            }
        } catch (IOException | InterruptedException | JsonParseException e) {
            System.err.println("Lỗi: " + e.getMessage());
            return null; // Lỗi kết nối hoặc phân tích JSON
        }
        
        
    }



    public static void main(String[] args) throws IOException, InterruptedException {

        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrow = currentDate.plusDays(1);// Lấy ngày mai (ngày hiện tại + 1 ngày)
        
      HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates?"+
                        "latitude=16.06800079345703"
                        +"&longitude=108.21199798583984"//SỬA KINH ĐỘ VĨ ĐỘ ĐỂ TRA CỨU, LẤY TỪ BÊN TRA CỨU THỜI TIẾT :V
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
              try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String jsonData=response.body();
             JSONObject jsonObject = new JSONObject(jsonData);
            //System.out.println(response.body());
              }catch (IOException | InterruptedException | JsonParseException e) {
            System.err.println("Lỗi: " + e.getMessage());
              }
              
         if (jsonObject.getBoolean("status")) {
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray results = data.getJSONArray("result");
            SearchHotel x=new SearchHotel();
            x.setVisible(true);
               
               
            // Duyệt qua mảng "result"
            for (int i = 0; i < results.length(); i++) {
                JSONObject hotel = results.getJSONObject(i);

                // Lấy các thông tin mong muốn
                int hotelId = hotel.getInt("hotel_id");
                String hotelName = hotel.getString("hotel_name");
                
                
                JSONObject composite_price_breakdown=hotel.getJSONObject("composite_price_breakdown");
                JSONObject all_inclusive_amount_hotel_currency=composite_price_breakdown.getJSONObject("all_inclusive_amount_hotel_currency");
                Integer price =all_inclusive_amount_hotel_currency.getInt("value");
                String currency=all_inclusive_amount_hotel_currency.getString("currency");
                
                double reivew=hotel.getDouble("review_score");
                double longitude=hotel.getDouble("longitude");//tung do
                double latitude=hotel.getDouble("latitude");//vido
                
                String address = getAddressFromCoordinates(latitude, longitude);

               /* System.out.println("Hotel Name: " + hotelName);
                System.out.println("Price: " + price+" "+currency);
                System.out.println("Review: " + reivew);
                //System.out.println("Tung độ "+longitude);
                //System.out.println("Vĩ độ "+latitude);
                System.out.println("Địa chỉ "+address);
                System.out.println("----------------------------------------");*/
                
                String PriceHotel =price+" "+currency;
                Object[] row = {hotelName,PriceHotel,reivew,address};
                x.updateDatatable(row);
                
            }
        } 
        else {
            System.out.println("Lỗi: " + jsonObject.getString("message"));
        }

    }

}
