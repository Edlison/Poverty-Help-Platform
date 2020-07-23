package com.edlison.marketing.DTO;

/**
 * swiper
 *
 * @Author Edlison
 * @Date 7/23/20 11:19
 */
public class SwiperDTO {
    private Long id;
    private Long attraction_id;
    private String img_src;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttraction_id() {
        return attraction_id;
    }

    public void setAttraction_id(Long attraction_id) {
        this.attraction_id = attraction_id;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }
}
