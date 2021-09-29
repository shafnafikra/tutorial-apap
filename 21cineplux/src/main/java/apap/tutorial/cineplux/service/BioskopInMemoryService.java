package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BioskopInMemoryService implements BioskopService {
    private List<BioskopModel> listBioskop;

    // Constructor
    public BioskopInMemoryService() {
        listBioskop = new ArrayList<>();
    }

    @Override
    public void addBioskop(BioskopModel bioskop) {
        listBioskop.add(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop) {

    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return listBioskop;
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        return null;
    }

    @Override
    public BioskopModel deleteBioskop(BioskopModel bioskop) {
        return null;
    }

//    @Override
//    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
//
//        for (BioskopModel bioskop : listBioskop) {
//            if (bioskop.getIdBioskop().equals(idBioskop)){
//                return bioskop;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteBioskop(BioskopModel bioskop) {
//        listBioskop.remove(bioskop);
//    }

}