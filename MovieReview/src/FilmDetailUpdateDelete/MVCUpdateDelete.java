/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilmDetailUpdateDelete;

/**
 *
 * @author Orenji
 */
public class MVCUpdateDelete {
    private String username, judul;

    public MVCUpdateDelete(String username, String judul) {
        this.username = username;
        this.judul = judul;
        UpdateDeleteView updateDeleteView = new UpdateDeleteView(judul, username);
        UpdateDeleteModel updateDeleteModel = new UpdateDeleteModel();
        UpdateDeleteController updateDeleteController = new UpdateDeleteController(updateDeleteView, updateDeleteModel);
    }

    public String getUsername() {
        return username;
    }

    public String getJudul() {
        return judul;
    }
    
    
}
