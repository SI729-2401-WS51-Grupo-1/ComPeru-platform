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

}
