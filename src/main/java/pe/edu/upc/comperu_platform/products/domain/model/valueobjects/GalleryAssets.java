package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Embeddable
public class GalleryAssets {
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImageAsset> images;

    public GalleryAssets() {
        this.images = new ArrayList<>();
    }

    public void addAsset(Product product, String url){
        ImageAsset imageAsset = new ImageAsset(product, url);
        this.images.add(imageAsset);
        System.out.println("New ImageAsset created: " + imageAsset);
    }


    public void removeAsset(Long id){
        ImageAsset imageToRemove = null;
        for (ImageAsset image : images) {
            if (image.getId().equals(id)) {
                imageToRemove = image;
                break;
            }
        }
        if (imageToRemove != null) {
            images.remove(imageToRemove);
        }
    }

    public Long getFirstImageIdInGalleryAssets(){
        return images.isEmpty() ? null : images.get(0).getId();
    }

    private ImageAsset getImageAssetWithId(Long imageId){
        return images.stream()
                .filter(image -> image.getId().equals(imageId))
                .findFirst()
                .orElse(null);
    }

    public ImageAsset getImageAssetWithUrl(String url){
        return images.stream()
                .filter(image -> image.getUrl().equals(url))
                .findFirst()
                .orElse(null);
    }



    public ImageAsset getLastImageAssetInGalleryAsset(){
        return images.isEmpty() ? null : images.get(images.size() - 1);
    }



    public boolean isEmpty(){
        return images.isEmpty();
    }
}