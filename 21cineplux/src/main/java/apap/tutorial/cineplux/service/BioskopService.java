package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import java.util.List;

public interface BioskopService{
    //Method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    //Method untuk mendapatkan daftar Bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    //Method untuk mendapatkan data sebuah Bioskop berdasarkan idnya
    BioskopModel getBioskopByIdBioskop(String idBioskop);

    void deleteBioskop(BioskopModel bioskop);
}