package br.com.nomeempresa.restaurante.application.usecase.product;

import br.com.nomeempresa.restaurante.application.exception.ResourceNotFound;
import br.com.nomeempresa.restaurante.application.inout.input.ProductInput;
import br.com.nomeempresa.restaurante.application.inout.mapper.ProductInputOutputMapper;
import br.com.nomeempresa.restaurante.application.usecase.UseCase;
import br.com.nomeempresa.restaurante.domain.core.domain.entities.Product;
import br.com.nomeempresa.restaurante.domain.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EditProductUseCase implements UseCase<ProductInput, Product> {
    private final ProductGateway productGateway;
    private final ModelMapper modelMapper;

    @Override
    public Optional<Product> execute(final ProductInput productInput) {
        productGateway.findById(productInput.id()).orElseThrow(ResourceNotFound::new);

        return productGateway.save(ProductInputOutputMapper.INSTANCE.productInputToProduct(productInput));
    }
}
