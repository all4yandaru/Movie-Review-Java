/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hitung;

/**
 *
 * @author Orenji
 */
public class RataRataUser implements Hitung {
    private int nilai1;
    private int nilai2;
    private int nilai3;

    public RataRataUser(int nilai1, int nilai2, int nilai3) {
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
    }
    
    public int hitung(){
        return (nilai1 + nilai2 + nilai3)/3;
    }
}
