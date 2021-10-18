import { Hospede } from "./hospede.model";
import { Quarto } from "./quarto.model";

export interface Hospedagem{
    idHospedagem?: number;
    quarto: Quarto;
    hospede: Hospede;
    dtCheckin: Date;
    dtCheckout: Date;
}