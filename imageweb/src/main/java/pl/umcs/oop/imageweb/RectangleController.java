package pl.umcs.oop.imageweb;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class RectangleController {
    private List<Rectangle> rectangles = new ArrayList<>();
    @GetMapping("hello")
    public String hello() {
        return "Hello world";
    }
    @GetMapping("rect")
    public List<Rectangle> rect() {
        return rectangles;
    }

    @GetMapping("addrect")
    public void addrect(){
        rectangles.add(new Rectangle(5, 8, 300, 700, "green" ));
    }

    /*

    <svg width="300" height="130" xmlns="http://www.w3.org/2000/svg">
        <rect width="200" height="100" x="10" y="10" rx="20" ry="20" fill="blue" />
        Sorry, your browser does not support inline SVG.
    </svg>

    */
    @GetMapping("tosvg")
    public String tosvg(){
        StringBuilder result = new StringBuilder();
        result.append("<svg width=\"1000\" height=\"1000\">");
        for (Rectangle rect : rectangles){
            result.append(String.format("<rect width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" fill=\"%s\"/>", rect.getWidth(), rect.getHeight(), rect.getX(), rect.getY(), rect.getColor()));
        }
        result.append("</svg>");
        return result.toString();
    }


    @PostMapping("rect")
    public void postrect(@RequestBody Rectangle rectangle){
        rectangles.add(rectangle);
    }
    //  curl -X POST -H "Content-Type: application/json" -d "{\"x\":50, \"y\":70, \"w\":100, \"h\":100, \"color\":\"blue\"}" localhost:8080/rect
   

    @GetMapping("rect/{index}")
    public Rectangle getRecByIndex(@PathVariable int index){
        return rectangles.get(index);
    }
    //  curl http://localhost:8080/rect/0

    @PutMapping("rect/{index}")
    public void putRecByIndex(@PathVariable int index, @RequestBody Rectangle rec){
        rectangles.set(index,rec);
    }
//    curl -X PUT -H "Content-Type: application/json" -d "{\"x\":50, \"y\":70, \"w\":150, \"h\":150, \"color\":\"red\"}" http://localhost:8080/rect/1
    @DeleteMapping("rect/{index}")
    public void deleteRecByIndex(@PathVariable int index){
        rectangles.remove(index);
    }
    //  curl -X DELETE http://localhost:8080/rect/1
}
