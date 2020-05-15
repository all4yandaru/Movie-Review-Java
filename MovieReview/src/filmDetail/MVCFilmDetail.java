/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmDetail;

/**
 *
 * @author Satya
 */
public class MVCFilmDetail {
    private String id_movie;

    public MVCFilmDetail(String id_movie) {
        this.id_movie = id_movie;
        FilmDetailView viewnya = new FilmDetailView(id_movie);
        FilmDetailModel modelnya = new FilmDetailModel();
        FilmDetailController controller = new FilmDetailController(modelnya, viewnya);
    }

    public String getId_movie() {
        return id_movie;
    }
    
}
