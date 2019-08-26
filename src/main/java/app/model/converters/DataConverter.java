package app.model.converters;

public interface DataConverter<E ,M> {

    public M toModel(E entity);

}
