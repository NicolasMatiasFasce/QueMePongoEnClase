package proveedores_de_clima.accuweather;

import excepciones.UnidadDeTemperaturaDesconocidaException;
import proveedores_de_clima.IProveedorClima;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProveedorAccuWeather implements IProveedorClima {

    private AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();

    private Integer ultimaTemperatura;
    private LocalDateTime ultimaActualizacion;

    @Override
    public Integer obtenerTemperaturaActual(String ciudad) {
        if (hayQueActualizarTemperatura()) {
            actualizarTemperatura(ciudad);
        }
        return ultimaTemperatura;
    }

    private void actualizarTemperatura(String ciudad) {
        List<Map<String, Object>> clima = accuWeatherAPI.getWeather(ciudad);
        HashMap<String, Object> temperatureMap = (HashMap<String, Object>) clima.get(0).get("Temperature");
        Integer value = (Integer) temperatureMap.get("Value");
        String unit = (String) temperatureMap.get("Unit");
        ultimaTemperatura = temperaturaEnCelsius(value, unit);
        ultimaActualizacion = LocalDateTime.now();
    }

    private Boolean hayQueActualizarTemperatura() {
        // Comparo por minutos por las dudas de un redondeo que haga que actualice cada 12:59 hs
        return Duration.between(LocalDateTime.now(), ultimaActualizacion).toMinutes() > (12 * 60);
    }

    private Integer temperaturaEnCelsius(Integer value, String unit) {
        switch (unit) {
            case "F":
                return deFahrenheitACelsius(value);
            case "C":
                return value;
            default:
                throw new UnidadDeTemperaturaDesconocidaException(format("%s no es una unidad de temperatura conocida", unit));
        }
    }

    private Integer deFahrenheitACelsius(Integer fahrenheit) {
        double enGradosCentigrados = (fahrenheit - 32) / 1.8;
        return (int) Math.round(BigDecimal.valueOf(enGradosCentigrados).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
    }

    @Override
    public Boolean estaActivo() {
        return true;
    }

}
