package io.db.olive.scanning;

import io.db.olive.data.OLSerializable;
import io.db.olive.sql.OLPredicate;

public interface OLWriteableScan extends OLScan {
    public void update(OLPredicate predicate, String fieldName, OLSerializable<?> value) throws Exception;
    public void delete(OLPredicate predicate);
}
