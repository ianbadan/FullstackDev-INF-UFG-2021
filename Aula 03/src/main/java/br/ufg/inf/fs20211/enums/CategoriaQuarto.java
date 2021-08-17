package br.ufg.inf.fs20211.enums;

public enum CategoriaQuarto {
    SIMPLES(0, "Simples"),
    PADRAO(1, "Padrão"),
    APARTAMENTO(2, "Apartamento"),
    DORMITORIO(3, "Dormitório"),
    LUXO(4, "Luxo");

    private Integer id;
    private String value;

    CategoriaQuarto(Integer id, String value){
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static CategoriaQuarto get(Integer id){
        CategoriaQuarto categoriaQuarto = null;
        for(CategoriaQuarto cq: CategoriaQuarto.values()){
            if(cq.getId() == id){
                categoriaQuarto = cq;
                break;
            }
        }
        return categoriaQuarto;
    }
}
