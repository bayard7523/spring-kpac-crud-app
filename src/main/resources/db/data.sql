INSERT INTO knowledge_packages (id, title, description, created_at)
VALUES (1, 'Deep Learning Fundamentals',
        'Explores neural networks, their architectures, and techniques used for training deep learning models.',
        '2023-04-15'),
       (2, 'Applied Machine Learning Techniques',
        'Focuses on practical applications of machine learning in various industries, including finance, healthcare, and marketing.',
        '2022-09-27'),
       (3, 'Statistical Learning Theory',
        'Covers the theoretical underpinnings of machine learning algorithms, including probability theory and statistical inference.',
        '2024-11-10'),
       (4, 'Renaissance Art and Its Impact',
        'Examines the art, culture, and historical significance of the Renaissance period, highlighting key artists and works.',
        '2023-06-03'),
       (5, 'Modern Art: From Impressionism to Abstract Expressionism',
        'Traces the evolution of modern art movements, emphasizing the transition from representational to abstract art.',
        '2022-10-19'),
       (6, 'Cosmology and the Structure of the Universe',
        'Investigates the origin, evolution, and large-scale structure of the universe, including the Big Bang theory and dark matter.',
        '2024-12-08'),
       (7, 'Stellar Evolution and Life Cycles of Stars',
        'Explores the formation, evolution, and eventual fate of stars, including phenomena such as supernovae and black holes.',
        '2023-08-22'),
       (8, 'Galactic Astronomy',
        'Studies the structure, dynamics, and components of galaxies, including the Milky Way and distant galaxies.',
        '2024-04-05'),
       (9, 'Quantum Field Theory',
        'Introduces the principles of quantum field theory, which combines classical field theory, quantum mechanics, and special relativity.',
        '2022-11-17'),
       (10, 'Quantum Computing',
        'Discusses the principles of quantum computation and information, including qubits, entanglement, and quantum algorithms.',
        '1987-03-12'),
       (11, 'Advanced Quantum Mechanics',
        'Delves deeper into the mathematical formalism of quantum mechanics, covering topics such as perturbation theory and quantum statistics',
        '1992-07-25'),
       (12, 'Mesopotamian Civilization',
        'Explores the history, culture, and contributions of Mesopotamia, often referred to as the cradle of civilization',
        '2005-11-08'),
       (13, 'Ancient Egyptian Civilization',
        'Examines the history, religion, and monumental architecture of ancient Egypt, including the pyramids and pharaohs.',
        '2010-01-15'),
       (14, 'Classical Greece and Rome',
        'Studies the development, achievements, and lasting impact of Greek and Roman civilizations on the modern world.',
        '2018-06-03'),
       (15, 'Advanced Python Programming',
        'Focuses on more advanced Python concepts, such as decorators, generators, and context managers.',
        '1975-09-21'),
       (16, 'Data Analysis with Python',
        'Covers the use of Python libraries such as pandas, NumPy, and Matplotlib for data analysis and visualization.',
        '1983-02-09'),
       (17, 'Python for Web Development',
        'Introduces web development using Python frameworks such as Django and Flask',
        '2000-08-19'),
       (18, 'Natural Language Processing',
        'Explores techniques for processing and analyzing human language data, including sentiment analysis and machine translation',
        '1999-04-04'),
       (19, 'Computer Vision',
        'Studies the methods for enabling machines to interpret and understand visual information from the world.',
        '2022-10-27'),
       (20, 'Reinforcement Learning',
        'Covers the concepts and algorithms behind reinforcement learning, where agents learn to make decisions by interacting with their environment.',
        '2015-05-14'),
       (21, 'Romantic Poetry and Prose',
        'Examines the key themes, authors, and works of the Romantic period, including the emphasis on emotion and nature.',
        '1996-12-30'),
       (22, 'Victorian Literature',
        'Analyzes the literature of the Victorian era, focusing on its social, political, and cultural contexts.',
        '1989-11-11'),
       (23, 'Modernist Literature',
        'Studies the experimental and innovative literary techniques of the Modernist period, highlighting authors such as James Joyce and Virginia Woolf.',
        '2003-07-20'),
       (24, 'Advanced Algorithms',
        'Delves into complex algorithms and their applications, including graph algorithms, dynamic programming, and computational geometry.',
        '2021-01-07'),
       (25, 'Data Structures in Practice',
        'Focuses on the practical implementation and optimization of data structures in real-world applications.',
        '2016-10-18'),
       (26, 'Algorithm Design and Analysis',
        'Covers the principles of designing efficient algorithms and analyzing their performance using asymptotic notation.',
        '1978-03-22');

INSERT INTO knowledge_package_sets(id, title)
VALUES (1, 'Introduction to Machine Learning'),
       (2, 'History of Art Movements'),
       (3, 'Introduction to Astrophysics'),
       (4, 'Introduction to Quantum Mechanics'),
       (5, 'World History: Ancient Civilizations'),
       (6, 'Introduction to Python Programming'),
       (7, 'Introduction to Artificial Intelligence'),
       (8, 'European Literature: From Romanticism to Modernism'),
       (9, 'Introduction to Data Structures and Algorithms');

INSERT INTO kpac_kpacsets
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 7),
       (3, 8),
       (3, 9),
       (4, 10),
       (4, 11),
       (4, 12),
       (5, 13),
       (5, 14),
       (5, 15),
       (6, 16),
       (6, 17),
       (6, 18),
       (7, 19),
       (7, 20),
       (7, 21),
       (8, 22),
       (8, 23),
       (8, 24),
       (9, 25),
       (9, 26);
