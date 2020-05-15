/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmLengkap;


/**
 *
 * @author Satya
 */
public class MVCFilmLengkap {
    ViewFilmLengkap viewnya = new ViewFilmLengkap();
    ModelFilmLengkap modelnya = new ModelFilmLengkap();
    ControllerFilmLengkap controllernya  = new ControllerFilmLengkap(modelnya, viewnya);
}
