package app.services;

import app.model.dto.BreadCrumbsDto;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class BreadCrumbsService {

    List<BreadCrumbsDto> list;

    public BreadCrumbsService(){
        list = new LinkedList<>();
    }

    public Builder builder(){
        if (!list.isEmpty()){
            list.clear();
        }
        return new Builder();
    }




    public class Builder{
        public Builder add(String name, String url){
            list.add(new BreadCrumbsDto(name, url));
            return this;
        }

        public List<BreadCrumbsDto> build(){
            return list;
        }
    }

}
