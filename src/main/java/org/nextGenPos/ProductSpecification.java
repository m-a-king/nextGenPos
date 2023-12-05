package org.nextGenPos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class ProductSpecification {
    private final ItemID itemID;
    private final Money price;
    private final String description;

}
