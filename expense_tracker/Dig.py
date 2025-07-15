from graphviz import Digraph

# Create ER diagram using Graphviz
er_diagram = Digraph(format="png", comment="ER Diagram for Expense Tracker Application")

# Entities
er_diagram.node("User", "User\n- UserID (PK)\n- Name\n- Email\n- Password", shape="rectangle")
er_diagram.node("Expense", "Expense\n- ExpenseID (PK)\n- Amount\n- Date\n- Description\n- UserID (FK)\n- CategoryID (FK)", shape="rectangle")
er_diagram.node("Category", "Category\n- CategoryID (PK)\n- CategoryName", shape="rectangle")

# Relationships
er_diagram.node("Has", "Has", shape="diamond")
er_diagram.node("BelongsTo", "Belongs To", shape="diamond")

# Edges (relationships)
er_diagram.edge("User", "Has", label="1")
er_diagram.edge("Has", "Expense", label="N")
er_diagram.edge("Expense", "BelongsTo", label="N")
er_diagram.edge("BelongsTo", "Category", label="1")

# Render and display the diagram
er_diagram_file = "/mnt/data/ER_Diagram_Expense_Tracker"
er_diagram.render(er_diagram_file, format="png", cleanup=True)
er_diagram_file + ".png"
