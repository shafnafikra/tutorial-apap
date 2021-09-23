package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);

    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);

    PenjagaModel updatePenjaga(PenjagaModel penjaga);

    PenjagaModel deletePenjaga(PenjagaModel penjaga);

    List<PenjagaModel> getPenjagaList();
}
