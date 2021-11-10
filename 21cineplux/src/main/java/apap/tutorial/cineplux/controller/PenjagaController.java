package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PenjagaController {

    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagasubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    // @{/penjaga/update/} + ${bioskop.noBioskop}+'/NoPenjaga/' +${penjaga.noPenjaga}
    @GetMapping("/penjaga/update/{noBioskop}/NoPenjaga/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long noPenjaga,
            Model model
    ){
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        if(penjagaService.getPenjagaList().contains(penjaga)) {
            model.addAttribute("penjaga", penjaga);
            return "form-update-penjaga";
        }
        return "null-penjaga";
    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        if(penjagaService.updatePenjaga(penjaga) == null){
            return "bioskop-buka";
        }
        else {
            model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
            model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
            return "update-penjaga";
        }
    }

//    @GetMapping("/penjaga/delete/{noPenjaga}")
//    public String deletePenjaga(
//            @PathVariable Long noPenjaga,
//            Model model
//    ){
//        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
//        model.addAttribute( "penjaga",penjaga);
//
//        if(penjagaService.getPenjagaList().contains(penjaga)){
//            if(penjagaService.deletePenjaga(penjaga) == null){
//                return "bioskop-buka";
//            }
//            else {
//                model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
//                model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
//                penjagaService.deletePenjaga(penjaga);
//                return "delete-penjaga";
//            }
//        }else{
//            return "null-penjaga";
//        }
//
//    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        for (PenjagaModel penjaga:
        bioskop.getListPenjaga()){
            if(penjagaService.deletePenjaga(penjaga) == null){
                return "bioskop-buka";
            }
            penjagaService.deletePenjaga(penjaga);
        }
        return "delete-penjaga";
    }

}