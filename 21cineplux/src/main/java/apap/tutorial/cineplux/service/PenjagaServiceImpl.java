package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService {
    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }

    @Override
    public PenjagaModel updatePenjaga(PenjagaModel penjaga) {
        LocalTime time = LocalTime.now();
        LocalTime buka = penjaga.getBioskop().getWaktuBuka();
        LocalTime tutup = penjaga.getBioskop().getWaktuTutup();
        if(time.compareTo(buka) <= 0 || time.compareTo(tutup) >= 0){
            penjagaDB.save(penjaga);
            return penjaga;
        }
        else{
            return null;
        }
    }

    @Override
    public PenjagaModel deletePenjaga(PenjagaModel penjaga) {
        LocalTime time = LocalTime.now();
        LocalTime buka = penjaga.getBioskop().getWaktuBuka();
        LocalTime tutup = penjaga.getBioskop().getWaktuTutup();
        if(time.compareTo(buka) <= 0 || time.compareTo(tutup) >= 0){
            penjagaDB.delete(penjaga);
            return penjaga;
        }
        else{
            return null;
        }
    }

    public List<PenjagaModel> getPenjagaList() {
        return penjagaDB.findByOrderByNamaPenjagaAsc(); }

}