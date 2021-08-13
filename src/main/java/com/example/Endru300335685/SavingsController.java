package com.example.Endru300335685;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SessionAttributes({"id","desc","errMsg", "errorMessage"})
@RequestMapping
@Controller
public class SavingsController {


    DatabaseService service1;

    @Autowired
    Connection123 connect;



    //a mapping when someone enters file
    @RequestMapping(value = "/savings", method = RequestMethod.GET)
    public String showCategorypage(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {


        service1 = new DatabaseService(connect.connect());

        model.addAttribute("todos", service1.display());


        List<savings> filteredTodos = new ArrayList<savings>();

        filteredTodos = (List) model.get("todos");

        model.put("custno",filteredTodos.get(0).getCustno());
        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCdep());
        model.put("nyears",filteredTodos.get(0).getNyears());
        model.put("savtype",filteredTodos.get(0).getSavtype());


        return "savings";


    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCategoryPage2(ModelMap model) throws ClassNotFoundException, SQLException {

        service1 = new DatabaseService(connect.connect());

        model.addAttribute("todos", service1.display());


        List<savings> filteredTodos = new ArrayList<savings>();

        filteredTodos = (List) model.get("todos");

        model.put("custno",filteredTodos.get(0).getCustno());
        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCdep());
        model.put("nyears",filteredTodos.get(0).getNyears());
        model.put("savtype",filteredTodos.get(0).getSavtype());

        return "savings";




    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException{

        model.put("custno", id);

        savings cc = service1.search(id);

        model.put("custno",cc.getCustno());
        model.put("custname", cc.getCustname());
        model.put("cdep",cc.getCdep());
        model.put("nyears", cc.getNyears());
        model.put("savtype",cc.getSavtype());




        return "catedit";
    }



    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam String custno, @RequestParam String custname, @RequestParam Double cdep, @RequestParam Integer nyears, @RequestParam String savtype) throws ClassNotFoundException, SQLException {


        String iid = (String) model.get("custno");

        savings cc = new savings(custno, custname, cdep, nyears, savtype);
        service1.edit(cc,iid);

        return "redirect:/";

    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "catser";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model,  @RequestParam String custno, @RequestParam String custname, @RequestParam Double cdep, @RequestParam Integer nyears, @RequestParam String savtype) throws ClassNotFoundException, SQLException {
        if(!((service1.search(custno)) == null)){
            model.put("errorMessage", "Record Existing");
            return "redirect:/savings";
        }

        savings cc = new savings(custno, custname, cdep, nyears, savtype);

        service1.add(cc);

        model.clear();
        return "redirect:/savings";
    }

}
