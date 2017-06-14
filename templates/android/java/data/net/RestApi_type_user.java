package {{ app.package }}.data.net;

import {{ app.package }}.net.wrapper.{{ name }}Wrapper;
import {{ app.package }}.domain.entity.MessageEntity;
import {{ app.package }}.domain.entity.NoteEntity;
import {{ app.package }}.domain.entity.{{ name }}Entity;
import {{ app.package }}.domain.entity.VersionEntity;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import io.reactivex.Observable;

public interface RestApi {

    String URL_BASE = "http://192.168.0.10:3000";
    int API_VERSION = 1;
    String VERSION_HEADER = "application/vnd.railsapibase.v" + API_VERSION;

    @POST("/{{ name }}s")
    Observable<Response<{{ name|capitalize }}Entity>> create{{ name|capitalize }}(@Body {{ name|capitalize }}Wrapper {{ name }}Wrapper);

    @DELETE("/{{ name }}s/0")
    Observable<Response<Void>> delete{{ name|capitalize }}(@Header("Authorization") String token);

    @POST("/{{ name }}s/reset_password")
    Observable<Response<MessageEntity>> resetPassword(@Header("Authorization") String token,
                                                      @Body {{ name|capitalize }}Wrapper {{ name }}Wrapper);

    @POST("/{{ name }}s/login")
    Observable<Response<{{ name|capitalize }}Entity>> doLogin(@Body {{ name|capitalize }}Wrapper {{ name }}Wrapper);

    @DELETE("/{{ name }}s/logout")
    Observable<Response<Void>> doLogout(@Header("Authorization") String token);

    @GET("/versions/state")
    Observable<Response<VersionEntity>> checkVersionExpiration(
                                                            @Header("Authorization") String token);


}
