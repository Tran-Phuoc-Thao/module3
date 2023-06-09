package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerTienTe {

    @RequestMapping(value = "/tinhTien",method = RequestMethod.GET)
    public String showForm(){
        return "/views";
    }

    @RequestMapping(value = "/tinhTien",method = RequestMethod.POST)
    public String tinhTien(@RequestParam Double inputTien,@RequestParam Double outputTien , Model model){
        Double ketQua = inputTien/outputTien;

        model.addAttribute("ketQua",ketQua);
        return "/views";
    }


}
