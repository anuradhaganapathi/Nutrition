DROP TABLE IF EXISTS `mytable`;
CREATE TABLE mytable(
  id          int(11) NOT NULL AUTO_INCREMENT,
  Symptom     VARCHAR(150) NOT NULL,
  Nutrient    VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));