package com.gs.productservice.service;


import com.gs.productservice.dto.ProductDto;
import com.gs.productservice.repository.ProductRepository;
import com.gs.productservice.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public Flux<ProductDto> getAll(){
        return productRepository.findAll().map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> findById(String id){
        return this.productRepository.findById(id).map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono){
        return productDtoMono
                .map(EntityDtoUtil::dtoToEntity)
                .flatMap(this.productRepository::insert)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<ProductDto> updateProduct(String id,Mono<ProductDto> productDtoMono){
        return  this.productRepository
                .findById(id)
                .flatMap(product -> productDtoMono.map(EntityDtoUtil::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(this.productRepository::save)
                .map(EntityDtoUtil::toDto);
    }

    public Mono<Void> deleteProductById(String id){
        return this.productRepository.deleteById(id);
    }

}