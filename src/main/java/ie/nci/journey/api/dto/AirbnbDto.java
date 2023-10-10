package ie.nci.journey.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * AirbnbDto
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-10
 */
public class AirbnbDto {
    private Boolean error;
    private Headers headers;
    private List<Result> results;

    public static class Headers {
        @JsonProperty("response_time")
        private Long responseTime;
        @JsonProperty("response_timestamp")
        private String responseTimestamp;
        @JsonProperty("response_id")
        private Long responseId;

        public Long getResponseTime() {
            return responseTime;
        }

        public void setResponseTime(Long responseTime) {
            this.responseTime = responseTime;
        }

        public String getResponseTimestamp() {
            return responseTimestamp;
        }

        public void setResponseTimestamp(String responseTimestamp) {
            this.responseTimestamp = responseTimestamp;
        }

        public Long getResponseId() {
            return responseId;
        }

        public void setResponseId(Long responseId) {
            this.responseId = responseId;
        }
    }

    public static class Result {
        private String id;
        private String url;
        private String deeplink;
        private Integer position;
        private String name;
        private Integer bathrooms;
        private Integer bedrooms;
        private Integer beds;
        private String city;
        private List<String> images;
        private String hostThumbnail;
        private Boolean isSuperhost;
        private Boolean rareFind;
        private Double lat;
        private Double lng;
        private Integer persons;
        private Integer reviewsCount;
        private Double rating;
        private String type;
        private Long userId;
        private String address;
        private List<Integer> amenityIds;
        private List<String> previewAmenities;
        private String cancelPolicy;
        private Price price;

        public static class Price {
            private Integer rate;
            private String currency;
            private Integer total;
            private List<PriceItem> priceItems;

            public static class PriceItem {
                private String title;
                private Integer amount;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public Integer getAmount() {
                    return amount;
                }

                public void setAmount(Integer amount) {
                    this.amount = amount;
                }
            }

            public Integer getRate() {
                return rate;
            }

            public void setRate(Integer rate) {
                this.rate = rate;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public Integer getTotal() {
                return total;
            }

            public void setTotal(Integer total) {
                this.total = total;
            }

            public List<PriceItem> getPriceItems() {
                return priceItems;
            }

            public void setPriceItems(List<PriceItem> priceItems) {
                this.priceItems = priceItems;
            }
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDeeplink() {
            return deeplink;
        }

        public void setDeeplink(String deeplink) {
            this.deeplink = deeplink;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getBathrooms() {
            return bathrooms;
        }

        public void setBathrooms(Integer bathrooms) {
            this.bathrooms = bathrooms;
        }

        public Integer getBedrooms() {
            return bedrooms;
        }

        public void setBedrooms(Integer bedrooms) {
            this.bedrooms = bedrooms;
        }

        public Integer getBeds() {
            return beds;
        }

        public void setBeds(Integer beds) {
            this.beds = beds;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public String getHostThumbnail() {
            return hostThumbnail;
        }

        public void setHostThumbnail(String hostThumbnail) {
            this.hostThumbnail = hostThumbnail;
        }

        public Boolean getSuperhost() {
            return isSuperhost;
        }

        public void setSuperhost(Boolean superhost) {
            isSuperhost = superhost;
        }

        public Boolean getRareFind() {
            return rareFind;
        }

        public void setRareFind(Boolean rareFind) {
            this.rareFind = rareFind;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

        public Integer getPersons() {
            return persons;
        }

        public void setPersons(Integer persons) {
            this.persons = persons;
        }

        public Integer getReviewsCount() {
            return reviewsCount;
        }

        public void setReviewsCount(Integer reviewsCount) {
            this.reviewsCount = reviewsCount;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public List<Integer> getAmenityIds() {
            return amenityIds;
        }

        public void setAmenityIds(List<Integer> amenityIds) {
            this.amenityIds = amenityIds;
        }

        public List<String> getPreviewAmenities() {
            return previewAmenities;
        }

        public void setPreviewAmenities(List<String> previewAmenities) {
            this.previewAmenities = previewAmenities;
        }

        public String getCancelPolicy() {
            return cancelPolicy;
        }

        public void setCancelPolicy(String cancelPolicy) {
            this.cancelPolicy = cancelPolicy;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
