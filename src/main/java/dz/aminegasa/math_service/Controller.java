package dz.aminegasa.math_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
//@RequestMapping(path="/solution")
public class Controller {
    @Autowired
    private Solution solution;

    @GetMapping("/solution")
    public ResponseEntity<List<String>>  getFormulas(
            @RequestParam(required = true)String  num,
            @RequestParam(required = true)Integer target

    ) {
        if(!solution.isNumeric(num)  ||!solution.isNumeric(target+"")){
            return null;
        }

        return new ResponseEntity<>(solution.addOperators(num,target)
                , HttpStatus.OK);

    }
    @GetMapping("/")
    public String  feature(){
        return "get all formulas which equal a specific target" +
                " using (addition, subtraction and multiplication)\n" +
                "problem definition https://leetcode.com/problems/expression-add-operators";
    }

}
