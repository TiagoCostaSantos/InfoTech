//package br.com.infotech.controller.requests;
//
//import java.util.List;
//
//public class ProdutoRequest {
//
//    private List<String> caracteristicas;
//
//    public List<String> getCaracteristicas() {
//        return caracteristicas == null ? List.of() :
//                caracteristicas.stream()
//                        .filter(c -> c != null && !c.trim().isEmpty())
//                        .toList();
//    }
//
//    public void setCaracteristicas(List<String> caracteristicas) {
//        this.caracteristicas = caracteristicas;
//    }
//}
