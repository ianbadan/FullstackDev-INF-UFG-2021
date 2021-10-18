import { CategoriaQuarto } from "../enum/categoriaQuarto.enum";
import { Hotel } from "./hotel.model";

export interface Quarto{
    idQuarto?: number;
    hotel : Hotel;
    categoriaQuarto: CategoriaQuarto;
    qtdLeito: number;
    nrQuarto: number;
    prDiaria: number;
}
