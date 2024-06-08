/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salti_kuliah.controller;

import salti_kuliah.model.Kuliah;
import salti_kuliah.model.KuliahDao;
import salti_kuliah.view.FormKuliah;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author MuhFai10
 */
public class KuliahlController {
    FormKuliah formKuliah;
    Kuliah Kuliah;
    KuliahDao KuliahDao;
    int index;
    
    
    public KuliahlController(FormKuliah formMatkul){
        this.formKuliah = formMatkul;
        KuliahDao = new KuliahDao();
    }
    
    public void cancel(){
        formKuliah.getTxtKode().setText("");
        formKuliah.getTxtNama().setText("");
        formKuliah.getTxtSks().setText("");
        formKuliah.getTxtKelas().setText("");
        isiJadwal();
    }
    
    public void isiJadwal(){
        formKuliah.getCboJadwal().removeAllItems();
        formKuliah.getCboJadwal().addItem("Senin");
        formKuliah.getCboJadwal().addItem("Selasa");
        formKuliah.getCboJadwal().addItem("Rabu");
        formKuliah.getCboJadwal().addItem("Kamis");
        formKuliah.getCboJadwal().addItem("Jumat");
        formKuliah.getCboJadwal().addItem("Sabtu");
    }
    
    public void insert(){
        
        Kuliah = new Kuliah();
        Kuliah.setKode(formKuliah.getTxtKode().getText());
        Kuliah.setNama(formKuliah.getTxtNama().getText());
        Kuliah.setSks(formKuliah.getTxtSks().getText());
        Kuliah.setJadwal(formKuliah.getCboJadwal()
                .getSelectedItem().toString());
        Kuliah.setkelas(formKuliah.getTxtKelas().getText());
        KuliahDao.insert(Kuliah);
        JOptionPane.showMessageDialog(formKuliah,"Entri Data OK");
    }
    
    public void getMatkul(){
        int index = formKuliah.getTableKuliah().getSelectedRow();
        Kuliah = KuliahDao.getKuliah(index);
        if(Kuliah !=null){
            formKuliah.getTxtKode().setText(Kuliah.getKode());
            formKuliah.getTxtNama().setText(Kuliah.getNama());
            formKuliah.getTxtSks().setText(Kuliah.getSks());
            formKuliah.getCboJadwal()
                    .setSelectedItem(Kuliah.getJadwal());
            formKuliah.getTxtKelas().setText(Kuliah.getKelas());
        }else{
            JOptionPane.showMessageDialog(formKuliah, "Matkul Tidak ada");
        }
    }
    
    public void viewData(){
        DefaultTableModel tableModel = (DefaultTableModel)formKuliah.getTableKuliah().getModel();
        tableModel.setRowCount(0);
        List<Kuliah> data = KuliahDao.getAllKuliah();
        for (Kuliah Kuliah : data){
            Object[] row = {
                Kuliah.getKode(),
                Kuliah.getNama(),
                Kuliah.getSks(),
                Kuliah.getJadwal(),
                Kuliah.getKelas()
            };
            tableModel.addRow(row);
        }
    }
    
    public void update(){
        Kuliah.setKode(formKuliah.getTxtKode().getText());
        Kuliah.setNama(formKuliah.getTxtNama().getText());
        Kuliah.setSks(formKuliah.getTxtSks().getText());
        Kuliah.setJadwal(formKuliah.getCboJadwal().getSelectedItem().toString());
        Kuliah.setkelas(formKuliah.getTxtKelas().getText());
        KuliahDao.update(index, Kuliah);
        JOptionPane.showMessageDialog(formKuliah, "Update Data Ok");
    }
    
    public void delete(){
        KuliahDao.delete(index);
        JOptionPane.showMessageDialog(formKuliah, "Delete Data OK");
    }
}
