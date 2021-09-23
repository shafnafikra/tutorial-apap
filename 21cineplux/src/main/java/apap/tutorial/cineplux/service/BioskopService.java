package apap.tutorial.cineplux.service;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface BioskopService {
    void addBioskop(BioskopModel bioskop);
    void updateBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    BioskopModel getBioskopByNoBioskop(Long noBioskop);
    BioskopModel deleteBioskop(BioskopModel bioskop);
}
