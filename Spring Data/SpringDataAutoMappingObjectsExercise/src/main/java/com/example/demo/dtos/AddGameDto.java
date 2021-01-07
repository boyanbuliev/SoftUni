package com.example.demo.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddGameDto {
    @Pattern(regexp = "[A-Z].{2,99}", message = "Incorrect title")
    private String title;
    @Positive(message = "Incorrect price")
    private BigDecimal price;
    @Positive(message = "Incorrect size")
    private double size;
    @Length(min = 11, max = 11, message = "Incorrect trailer")
    private String trailer;
    @Pattern(regexp = "http:\\/\\/|https:\\/\\/.+$", message = "Incorrect thumbnail")
    private String imageThumbnail;
    @Size(min = 20, message = "Incorrect description")
    private String description;
    private LocalDate releaseDate;

    public AddGameDto() {
    }

    public AddGameDto(String title, BigDecimal price, double size, String trailer,
                      String imageThumbnail, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.imageThumbnail = imageThumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
