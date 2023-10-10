package ie.nci.journey.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherDto
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-10
 */
public class WeatherDto {
    private Location location;
    private Current current;

    public static class Location {
        private String name;
        private String region;
        private String country;
        private Double lat;
        private Double lon;
        @JsonProperty("tz_id")
        private String tzId;
        @JsonProperty("localtime_epoch")
        private Long localtimeEpoch;
        @JsonProperty("localtime")
        private String localTime;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public String getTzId() {
            return tzId;
        }

        public void setTzId(String tzId) {
            this.tzId = tzId;
        }

        public Long getLocaltimeEpoch() {
            return localtimeEpoch;
        }

        public void setLocaltimeEpoch(Long localtimeEpoch) {
            this.localtimeEpoch = localtimeEpoch;
        }

        public String getLocalTime() {
            return localTime;
        }

        public void setLocalTime(String localTime) {
            this.localTime = localTime;
        }
    }

    public static class Current {
        @JsonProperty("last_updated_epoch")
        private Long lastUpdatedEpoch;
        @JsonProperty("last_updated")
        private String lastUpdated;
        @JsonProperty("temp_c")
        private Double tempC;
        @JsonProperty("temp_f")
        private Double tempF;
        @JsonProperty("is_day")
        private Integer isDay;
        private Condition condition;
        @JsonProperty("wind_mph")
        private Double windMph;
        @JsonProperty("wind_kph")
        private Double windKph;
        @JsonProperty("wind_degree")
        private Integer windDegree;
        @JsonProperty("wind_dir")
        private String windDir;
        @JsonProperty("pressure_mb")
        private Double pressureMb;
        @JsonProperty("pressure_in")
        private Double pressureIn;
        @JsonProperty("precip_mm")
        private Double precipMm;
        @JsonProperty("precip_in")
        private Double precipIn;
        private Integer humidity;
        private Integer cloud;
        @JsonProperty("feelslike_c")
        private Double feelslikeC;
        @JsonProperty("feelslike_f")
        private Double feelslikF;
        @JsonProperty("vis_km")
        private Double visKm;
        @JsonProperty("vis_miles")
        private Double visMiles;
        private Double uv;
        @JsonProperty("gust_mph")
        private Double gustMph;
        @JsonProperty("gust_kph")
        private Double gustKph;

        public static class Condition {
            private String text;
            private String icon;
            private Integer code;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Integer getCode() {
                return code;
            }

            public void setCode(Integer code) {
                this.code = code;
            }
        }

        public Long getLastUpdatedEpoch() {
            return lastUpdatedEpoch;
        }

        public void setLastUpdatedEpoch(Long lastUpdatedEpoch) {
            this.lastUpdatedEpoch = lastUpdatedEpoch;
        }

        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public Double getTempC() {
            return tempC;
        }

        public void setTempC(Double tempC) {
            this.tempC = tempC;
        }

        public Double getTempF() {
            return tempF;
        }

        public void setTempF(Double tempF) {
            this.tempF = tempF;
        }

        public Integer getIsDay() {
            return isDay;
        }

        public void setIsDay(Integer isDay) {
            this.isDay = isDay;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public Double getWindMph() {
            return windMph;
        }

        public void setWindMph(Double windMph) {
            this.windMph = windMph;
        }

        public Double getWindKph() {
            return windKph;
        }

        public void setWindKph(Double windKph) {
            this.windKph = windKph;
        }

        public Integer getWindDegree() {
            return windDegree;
        }

        public void setWindDegree(Integer windDegree) {
            this.windDegree = windDegree;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public Double getPressureMb() {
            return pressureMb;
        }

        public void setPressureMb(Double pressureMb) {
            this.pressureMb = pressureMb;
        }

        public Double getPressureIn() {
            return pressureIn;
        }

        public void setPressureIn(Double pressureIn) {
            this.pressureIn = pressureIn;
        }

        public Double getPrecipMm() {
            return precipMm;
        }

        public void setPrecipMm(Double precipMm) {
            this.precipMm = precipMm;
        }

        public Double getPrecipIn() {
            return precipIn;
        }

        public void setPrecipIn(Double precipIn) {
            this.precipIn = precipIn;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Integer getCloud() {
            return cloud;
        }

        public void setCloud(Integer cloud) {
            this.cloud = cloud;
        }

        public Double getFeelslikeC() {
            return feelslikeC;
        }

        public void setFeelslikeC(Double feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        public Double getFeelslikF() {
            return feelslikF;
        }

        public void setFeelslikF(Double feelslikF) {
            this.feelslikF = feelslikF;
        }

        public Double getVisKm() {
            return visKm;
        }

        public void setVisKm(Double visKm) {
            this.visKm = visKm;
        }

        public Double getVisMiles() {
            return visMiles;
        }

        public void setVisMiles(Double visMiles) {
            this.visMiles = visMiles;
        }

        public Double getUv() {
            return uv;
        }

        public void setUv(Double uv) {
            this.uv = uv;
        }

        public Double getGustMph() {
            return gustMph;
        }

        public void setGustMph(Double gustMph) {
            this.gustMph = gustMph;
        }

        public Double getGustKph() {
            return gustKph;
        }

        public void setGustKph(Double gustKph) {
            this.gustKph = gustKph;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

}
