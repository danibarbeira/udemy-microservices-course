package com.in28minutes.rest.webservice.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringRestController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("val1", "val2", "val3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return List.of(new SomeBean("val1", "val2", "val3"), new SomeBean("val4", "val5", "val6"));
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filteringDynamic() {
        SomeDynamicBean someDynamicBean = new SomeDynamicBean("val1", "val2", "val3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someDynamicBean);
        this.addFilterToMapping(mappingJacksonValue, "SomeDynamicBeanFilter", "field1", "field3");
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-dynamic-list")
    public MappingJacksonValue filteringDynamicList() {
        List<SomeDynamicBean> someDynamicBeans = List.of(new SomeDynamicBean("val1", "val2", "val3"), new SomeDynamicBean("val4", "val5", "val6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someDynamicBeans);
        this.addFilterToMapping(mappingJacksonValue, "SomeDynamicBeanFilter", "field2");
        return mappingJacksonValue;
    }

    private void addFilterToMapping(MappingJacksonValue mappingJacksonValue, String filterId, String... propertiesToKeep) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(propertiesToKeep);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterId, simpleBeanPropertyFilter);
        mappingJacksonValue.setFilters(filterProvider);
    }

}
