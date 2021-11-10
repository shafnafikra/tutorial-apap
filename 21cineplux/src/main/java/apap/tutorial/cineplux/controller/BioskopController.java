package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util. ArrayList;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @Autowired
    FilmService filmService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        List<FilmModel> temp = new ArrayList<>();
        BioskopModel bioskop = new BioskopModel();
        FilmModel film = new FilmModel();
        temp.add(film);
        bioskop.setListFilm(temp);

        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listAllFilm", filmService.getListFilm());
        return "form-add-bioskop";
    }

//    @PostMapping("/bioskop/add")
//    public String addBioskopsubmit(
//            @ModelAttribute BioskopModel bioskop,
//            Model model
//    ){
//        bioskopService.addBioskop(bioskop);
//        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
//        return "add-bioskop";
//    }

    @PostMapping(value="/bioskop/add/", params = {"submitBioskop"})
    private String submitBioskop(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.addBioskop(bioskop);
        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
        model.addAttribute( "listFilmAll", filmService.getListFilm());
        return "add-bioskop";
    }

    @PostMapping(value = "/bioskop/add/", params = {"addRow"})
    private String addRowFilm(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        //System.out.println("Masuk addrow");

        bioskop.getListFilm().add(new FilmModel());
        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listAllFilm", filmService.getListFilm());
        return "form-add-bioskop";
    }

    @PostMapping(value=("/bioskop/add/"), params = ("delete"))
    public String removeRowFilm(
            @ModelAttribute BioskopModel bioskop,
            @RequestParam("delete") int index,
            Model model
    ){
        bioskop.getListFilm().remove(index);
        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listAllFilm", filmService.getListFilm());
        return "form-add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
//        System.out.println(listBioskop);
        model.addAttribute ( "listBioskop", listBioskop);
        return "viewall-bioskop" ;
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if(bioskopService.getBioskopList().contains(bioskop)) {
            List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
            model.addAttribute( "bioskop", bioskop);
            model.addAttribute("listPenjaga", listPenjaga);
            model.addAttribute("listFilm", bioskop.getListFilm());
            return "view-bioskop";
        }else {
            return "null-bioskop";
        }
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ){
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if(bioskopService.getBioskopList().contains(bioskop)) {
            model.addAttribute("bioskop", bioskop);
            return "form-update-bioskop";
        }
        return "null-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.updateBioskop(bioskop);
        model.addAttribute( "noBioskop",bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskop(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        model.addAttribute("bioskop", bioskop);

        if (bioskopService.getBioskopList().contains(bioskop)) {
            if (bioskopService.deleteBioskop(bioskop) == null) {
                return "bioskop-buka";
            } else {
                if(bioskop.getListPenjaga().size()<1){
                    model.addAttribute("noBioskop", bioskop.getNoBioskop());
                    return "success-delete";
                }
                return "gabisa-delete-bioskop";
            }
        }
        return "null-bioskop";
    }
}