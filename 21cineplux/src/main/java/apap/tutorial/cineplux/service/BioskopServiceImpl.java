package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {
    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public void updateBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public List<BioskopModel> getBioskopList() {
        return bioskopDB.findByOrderByNamaBioskopAsc(); }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }
    @Override
    public BioskopModel deleteBioskop(BioskopModel bioskop) {
        LocalTime time = LocalTime.now();
        LocalTime buka = bioskop.getWaktuBuka();
        LocalTime tutup = bioskop.getWaktuTutup();
        if(time.compareTo(buka) <= 0 || time.compareTo(tutup) >= 0){
            bioskopDB.delete(bioskop);
            return bioskop;
        }
        else{
            return null;
        }
    }
}