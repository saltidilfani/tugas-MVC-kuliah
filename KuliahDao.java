/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salti_kuliah.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MuhFai10
 */
public class KuliahDao {
    private List<Kuliah> data = new ArrayList<Kuliah>();
    
    public KuliahDao(){
        data.add(new Kuliah("ISY3203", "Matematika Diskrit", "3", "Selasa", "210"));
         data.add(new Kuliah("ISY3202", "Sistem Operasi", "3", "Kamis", "301"));
          data.add(new Kuliah("ISY3303", "Pemrograman Berorientasi Objek", "4", "Jumat", "306"));
    }
    
    public void insert(Kuliah k){
        data.add(k);
    }
    
    public void update (int index, Kuliah k){
        data.set(index,k);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Kuliah getKuliah(int index){
        return data.get(index);
    }
    
    public List<Kuliah> getAllKuliah(){
        return data;
    } 
}