create table if not EXISTS "Recipes" (
	"ID" int not NULL PRIMARY KEY,
	"Name" varchar(30) not null,
	"Duration" int,
	"PersonAmount" int not null
);

create table if not EXISTS "Ingredients" (
	"ID" int not NULL PRIMARY KEY,
	"Name" varchar(30) not null
);

create table if not exists "Utensiles" (
	"ID" int not NULL PRIMARY KEY,	"Name" varchar(30) not null
);

create table if not exists "Steps" (
	"ID" int not NULL PRIMARY KEY,
	"Name" varchar(30) not null,
	"Description" varchar(500)
);

create table if not exists "Recipes_Ingredients" (	"Recipe_ID" int not null,	"Ingredient_ID" int not null,	"Amount" int not null,	"Unit" varchar(10),	FOREIGN KEY ("Recipe_ID") REFERENCES "Recipes"("ID"),	FOREIGN KEY ("Ingredient_ID") REFERENCES "Ingredients"("ID"));

create table if not exists "Utensiles_Recipes" (
	"Recipe_ID" int not null,
	"Utensile_ID" int not null,
	FOREIGN KEY ("Recipe_ID") REFERENCES "Recipes"("ID"),
	FOREIGN KEY ("Utensile_ID") REFERENCES "Utensiles"("ID")
);

create table if not exists "Steps_Recipes" (	"Recipe_ID" int not null,	"Step_ID" int not null,	FOREIGN KEY ("Recipe_ID") REFERENCES "Recipes"("ID"),	FOREIGN KEY ("Step_ID") REFERENCES "Steps"("ID"));