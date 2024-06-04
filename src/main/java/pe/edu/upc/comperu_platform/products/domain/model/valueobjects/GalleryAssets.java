package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
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

    public void AddAsset(String url){
        this.images.add(new ImageAsset(url));
    }

    public void RemoveAsset(Long id){
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
}
