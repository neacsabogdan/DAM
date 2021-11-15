package eu.ase.grupa1081.tema;

import java.util.List;

public interface IResponse {
    void onSuccess(List<Meal> lista);
    void onError(String errMessage);
}
