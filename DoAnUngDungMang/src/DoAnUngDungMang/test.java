/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoAnUngDungMang;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 *
 * @author DELL
 */
public class test {
    



    public static void main(String[] args) throws IOException, InterruptedException {


      HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotelsByCoordinates?"+
                        "latitude=16.06800079345703"
                        +"&longitude=108.21199798583984"//SỬA KINH ĐỘ VĨ ĐỘ ĐỂ TRA CỨU, LẤY TỪ BÊN TRA CỨU THỜI TIẾT :V
                        +"&arrival_date=2025-03-24"
                        +"&departure_date=2025-03-28"
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
System.out.println(response.body());



    }

}
