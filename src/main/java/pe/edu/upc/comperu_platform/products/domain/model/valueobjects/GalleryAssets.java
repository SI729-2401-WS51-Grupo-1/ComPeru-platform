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

    public void AddAsset(Product product, String url){

        ImageAsset imageAsset = new ImageAsset(product,url,null);
        ImageAsset originalLastImage = null;
        if(!images.isEmpty()){
            originalLastImage = getLastImageAssetInGalleryAsset();
        }
        this.images.add(imageAsset);
        if(originalLastImage !=null){
            originalLastImage.updateNextImage(imageAsset);
        }

    }

    public void AddAsset(Product product, String url, ImageAsset nextAsset){
        ImageAsset imageAsset = new ImageAsset(product,url,nextAsset);
        images.add(imageAsset);
    }

    public void AddAsset(Product product , String url, String nextUrl){
        ImageAsset nextImage = getImageAssetWithUrl(nextUrl);
        AddAsset(product,url,nextImage);

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

    public Long getFirstImageIdInGalleryAssets(){
        return images.getFirst().getId();
    }

    private ImageAsset getImageAssetWithId(Long imageId){
        return images.stream().filter(image ->image.getId().equals(imageId))
                .findFirst().orElse(null);
    }

    public ImageAsset getImageAssetWithUrl(String url){
        return images.stream().filter(image ->image.getUrl().equals(url))
                .findFirst().orElse(null);
    }

    public Long getNextImageInGalleryAssets(Long currentImageId){
        ImageAsset asset = getImageAssetWithId(currentImageId);
        return asset != null ? asset.getId():null;

    }

    public ImageAsset getLastImageAssetInGalleryAsset(){
        return images.stream().filter(image -> image.getNextImage() == null)
                .findFirst().orElse(null);
    }

    public boolean isLastImageInGallery(Long currentImageId){
        return getNextImageInGalleryAssets(currentImageId) == null;
    }

    public boolean isEmpty(){
        return images.isEmpty();
    }





}
