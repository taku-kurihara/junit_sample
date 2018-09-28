package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p>
 * modelのサンプルクラス.
 * </p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Model {
    /** DBのプライマリキー. */
    private int id;
    /** モデル名. */
    private String name;
}

