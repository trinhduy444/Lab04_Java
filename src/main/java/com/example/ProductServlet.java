package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<Product> products = new ArrayList<Product>();
    private Gson gson = new Gson();
    public ProductServlet() {
        super();}

    public void init() {
        this.products.add(new Product(0, "Samsung Z Clip", 1000));
        this.products.add(new Product(1, "iPhone 14", 2000));
        this.products.add(new Product(2, "Samsung Galaxy Note 9", 600));
        this.products.add(new Product(3, "Nokia 1280", 50));
        this.products.add(new Product(4, "Samsung Galaxy Fold 3", 3000));
        this.products.add(new Product(5, "Asus ROG Phone 4", 1000));
        this.products.add(new Product(6, "iPhone X", 1100));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject json = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        int jsonCode = 0;
        String jsonMessage = "";

        if (request.getParameter("id") != null) {
            int productId = Integer.parseInt(request.getParameter("id"));
            Product product = null;
            for (Product p: this.products) {
                if (p.getId() == productId) {
                    product = p;
                    break;
                }
            }

            if (product != null) {
                JsonObject js = new JsonObject();
                js.addProperty("id", product.getId());
                js.addProperty("name", product.getName());
                js.addProperty("price", product.getPrice());
                jsonArray.add(js);

                jsonCode = 0;
                jsonMessage = "?????c s???n ph???m th??nh c??ng.";
            } else {
                jsonCode = 2;
                jsonMessage = "Kh??ng t??m th???y s???n ph???m n??o v???i m?? s??? " + productId + ".";
            }
        } else {
            jsonCode = 0;
            jsonMessage = "?????c s???n ph???m th??nh c??ng.";

            for (Product p: this.products) {
                JsonObject js = new JsonObject();
                js.addProperty("id", p.getId());
                js.addProperty("name", p.getName());
                js.addProperty("price", p.getPrice());
                jsonArray.add(js);
            }
        }

        json.addProperty("code", jsonCode);
        json.addProperty("message", jsonMessage);
        if (jsonArray.size() > 0) {
            json.add("data", jsonArray);
        }

        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject json = new JsonObject();

        if (!request.getParameter("id").isEmpty() && !request.getParameter("name").isEmpty() && !request.getParameter("price").isEmpty()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));

            boolean existId = false;

            for (Product p: this.products) {
                if (p.getId() == id) {
                    json.addProperty("code", 1);
                    json.addProperty("message", "Tr??ng id s???n ph???m, vui l??ng nh???p id kh??c.");
                    existId = true;
                    break;
                }
            }

            if (!existId) {
                Product product = new Product(id, name, price);
                this.products.add(product);
                json.addProperty("code", 0);
                json.addProperty("message", "Th??m s???n ph???m m???i th??nh c??ng.");
            }
        } else {
            json.addProperty("code", 1);
            json.addProperty("message", "Vui l??ng nh???p ?????y ????? id, name, price c???a s???n ph???m.");

        }

        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject json = new JsonObject();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        if(!id.isEmpty() && !name.isEmpty() && !price.isEmpty()) {
            int id_p = Integer.parseInt(id);
            int price_p = Integer.parseInt(price);

            boolean existId = false;

            for(Product p : this.products) {
                if(p.getId() == id_p) {
                    int index = this.products.indexOf(p);
                    this.products.get(index).setName(name);
                    this.products.get(index).setPrice(price_p);
                    existId = true;
                    json.addProperty("code", 0);
                    json.addProperty("message", "C???p nh???p th??nh c??ng!!!");
                    break;
                }
            }

            if(!existId) {
                json.addProperty("code", 1);
                json.addProperty("message", "S???n ph???m kh??ng t???n t???i!!!");
            }
        }else {
            json.addProperty("code", 1);
            json.addProperty("message", "Vui l??ng nh???p ?????y ????? id, name, price c???a s???n ph???m.");

        }

        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

}
