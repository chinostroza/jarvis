package cl.multicaja.testcode.data.net;

import cl.multicaja.testcode.data.net.wrapper.UserWrapper;
import cl.multicaja.testcode.domain.entity.MessageEntity;
import cl.multicaja.testcode.domain.entity.NoteEntity;
import cl.multicaja.testcode.domain.entity.UserEntity;
import cl.multicaja.testcode.domain.entity.VersionEntity;

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


    @GET("/versions/state")
    Observable<Response<VersionEntity>> checkVersionExpiration(
                                                            @Header("Authorization") String token);

    @POST("/notes")
    Observable<Response<NoteEntity>> createNote(@Header("Authorization") String token,
                                                @Body NoteEntity note);

    @GET("/notes/{id}")
    Observable<Response<NoteEntity>> getNote(@Header("Authorization") String token,
                                             @Path("id") int noteId);

    @GET("/notes")
    Observable<Response<List<NoteEntity>>> getNotes(@Header("Authorization") String token);

    @PUT("/notes/{id}")
    Observable<Response<NoteEntity>> updateNote(@Header("Authorization") String token,
                                                @Path("id") int noteId, @Body NoteEntity note);

    @DELETE("/notes/{id}")
    Observable<Response<Void>> deleteNote(@Header("Authorization") String token,
                                          @Path("id") int noteId);

}
