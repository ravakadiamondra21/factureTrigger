CREATE TABLE IF NOT EXISTS facture (
    num_facture SERIAL PRIMARY KEY,
    nom VARCHAR(255),
    montant DOUBLE PRECISION,
    date_facture DATE,
    user_id INT
);

CREATE TABLE IF NOT EXISTS audit (
    id_audit SERIAL PRIMARY KEY,
    username TEXT,
    action_type TEXT,
    action_timestamp TIMESTAMP,
    host_name TEXT,
    montant_ancien DOUBLE PRECISION,
    montant_nouveau DOUBLE PRECISION,
    facture_id INT
);

CREATE OR REPLACE FUNCTION audit_facture()
RETURNS TRIGGER AS $$
DECLARE
    v_username TEXT;
    v_host TEXT;
BEGIN
    v_username := current_setting('app.current_user', true);
    v_host := inet_client_addr()::text;

    IF TG_OP = 'INSERT' THEN
        INSERT INTO audit(username, action_type, action_timestamp, host_name, montant_ancien,  montant_nouveau, facture_id)
        VALUES (v_username, 'CREATE', NOW(), v_host, NULL, NEW.montant, NEW.num_facture);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO audit(username, action_type, action_timestamp, host_name, montant_ancien,  montant_nouveau, facture_id)
        VALUES (v_username, 'UPDATE', NOW(), v_host, OLD.montant, NEW.montant, NEW.num_facture);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO audit(username, action_type, action_timestamp, host_name, montant_ancien,  montant_nouveau, facture_id)
        VALUES (v_username, 'DELETE', NOW(), v_host, OLD.montant, NULL, OLD.num_facture);
        RETURN OLD;
    END IF;
    RETURN NULL;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trigger_audit ON facture;
CREATE TRIGGER trigger_audit
AFTER INSERT OR UPDATE OR DELETE ON facture
FOR EACH ROW EXECUTE FUNCTION audit_facture();