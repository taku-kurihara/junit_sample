package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
/**
 * <p>
 * modelのサンプルクラス.
 * </p>
 */
public class Model {
    /** DBのプライマリキー. */
    private int id;
    /** モデル名. */
    private String name;
}

