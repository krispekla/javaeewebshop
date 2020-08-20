INSERT INTO category(created, modified, logourl, name) VALUES(NOW(), NOW(), 'https://drive.google.com/uc?export=view&id=123irAngSti4BT73mgJ-_oGV69PKXuBDr', 'apple'),
                                                (NOW(), NOW(), 'https://drive.google.com/uc?export=view&id=1eV5C-gZ3Rebl3VgfPA6Jl9G5cq8uO-ac', 'google'),
                                                (NOW(), NOW(), 'https://drive.google.com/uc?export=view&id=1q7PwqdV_wBzEtTwrf_pJ5VV5FBqh-fl_', 'huawei'),
                                                (NOW(), NOW(), 'https://drive.google.com/uc?export=view&id=115678tG_7HutAe08AH2iNSn03mD6iZSR', 'lg'),
                                                (NOW(), NOW(), 'https://drive.google.com/uc?export=view&id=14mBBCkFOBLb2OsgRjDZEN2T9lapZDwju', 'samsung'),
                                                (NOW(), NOW(), 'https://drive.google.com/uc?export=view&id=1iG7VtowqrTIz_0YPFqGAFPsNxNZ09JPX', 'xiaomi')

INSERT INTO public."user"(created, modified, password, username, email, firstname, lastname) VALUES(NOW(), NOW(), 'Admin!123', 'admin', 'admin@admin.com', 'admin', 'admin'),
                            (NOW(), NOW(), 'Kris!123', 'kris', 'kris@kris.com', 'kris', 'pekla')

INSERT INTO user_role(name, username) VALUES('admin', 'admin'),
                                               ('customer', 'kris')

INSERT INTO product(date, description, imgurl, manufacturer, name, price, category_id) VALUES(NOW(), 'The iPhone XR looks similar to the 5.8-inch iPhone XS, but it features a bigger 6.1-inch display.', 'https://drive.google.com/uc?export=view&id=1l3DBzyeGJsFJD98fkCY_g2Y1XJVJyu1x', 'apple', 'iPhone XR', 860, 1),
        (NOW(), 'The iPhone X looks similar to the 5.8-inch iPhone X, but it features a bigger 6.1-inch display, so its a mid-sized phone that fell between the iPhone XS and the 6.5-inch iPhone X Max.', 'https://drive.google.com/uc?export=view&id=1bC_COC-hLy5n_-s5M9Ur-9l_nqsQ7C4q', 'apple', 'iPhone X', 920, 1),
        (NOW(), 'The iPhone 11 looks similar to the 5.8-inch iPhone 11, but it features a bigger 6.1-inch display, so its a mid-sized phone that fell between the iPhone XS and the 6.5-inch iPhone X Max.', 'https://drive.google.com/uc?export=view&id=1J7we2ik4p-VN4_fzEX-6HFRMcwdQkiqs', 'apple', 'iPhone 11',  740, 1),
        (NOW(), 'The iPhone 8 looks similar to the 5.8-inch iPhone 11, but it features a bigger 6.1-inch display, so its a mid-sized phone that fell between the iPhone XS and the 6.5-inch iPhone X Max.', 'https://drive.google.com/uc?export=view&id=1J7we2ik4p-VN4_fzEX-6HFRMcwdQkiqs', 'apple', 'iPhone 8',  599, 1),
        (NOW(), 'The iPhone 7 looks similar to the 5.8-inch iPhone 11, but it features a bigger 6.1-inch display, so its a mid-sized phone that fell between the iPhone XS and the 6.5-inch iPhone X Max.', 'https://drive.google.com/uc?export=view&id=1J7we2ik4p-VN4_fzEX-6HFRMcwdQkiqs', 'apple', 'iPhone 7',  399, 1),
        (NOW(), 'The iPhone 6s looks similar to the 5.8-inch iPhone 11, but it features a bigger 6.1-inch display, so its a mid-sized phone that fell between the iPhone XS and the 6.5-inch iPhone X Max.', 'https://drive.google.com/uc?export=view&id=1J7we2ik4p-VN4_fzEX-6HFRMcwdQkiqs', 'apple', 'iPhone 6s',  340, 1),
        (NOW(), 'Google Pixel 4 is a brand of consumer electronic devices developed by Google that run either Chrome OS or the Android operating system. The Pixel brand was introduced in February 2013 with the first-generation Chromebook Pixel.', 'https://drive.google.com/uc?export=view&id=1cb6qAKKBKJLyZVazwdZhQaI2JWGFAKz6', 'google', 'Google Pixel 4', 780, 2),
        (NOW(), 'Google Pixel 3 is a brand of consumer electronic devices developed by Google that run either Chrome OS or the Android operating system.', 'https://drive.google.com/uc?export=view&id=1aC5wyO0_gBoxDtoS-RGC01Gqfk9fbeux', 'google', 'Google Pixel 3', 480, 2),
        (NOW(), 'Google Pixel 2 is a brand of consumer electronic devices developed by Google that run either Chrome OS or the Android operating system.', 'https://drive.google.com/uc?export=view&id=1cb6qAKKBKJLyZVazwdZhQaI2JWGFAKz6', 'google', 'Google Pixel 2', 270, 2),
        (NOW(), 'Huawei P20 smartphone was launched in March 2018. The phone comes with a 5.80-inch touchscreen display with a resolution of 1080x2244 pixels at a pixel density of 428 pixels per inch (ppi).', 'https://drive.google.com/uc?export=view&id=1UPubRkbE33E5CuHI8nkbK60TB9PlhjR3', 'huawei', 'Huawei p20', 520, 3),
        (NOW(), 'Huawei 9 smartphone was launched in March 2019. The phone comes with a 5.80-inch touchscreen display with a resolution of 1080x2244 pixels at a pixel density 4GB of RAM.', 'https://drive.google.com/uc?export=view&id=1_R8OKSxgCNB7gGUHyJFUDYBO-zosIYxq', 'huawei', 'Huawei 9', 590, 3),
        (NOW(), 'Huawei 8 smartphone was launched in March 2019. The phone comes with a 5.80-inch touchscreen display with a resolution of 1080x2244 pixels at a pixel density 4GB of RAM.', 'https://drive.google.com/uc?export=view&id=1_R8OKSxgCNB7gGUHyJFUDYBO-zosIYxq', 'huawei', 'Huawei 8', 450, 3),
        (NOW(), 'Huawei 7 smartphone was launched in March 2019. The phone comes with a 5.80-inch touchscreen display with a resolution of 1080x2244 pixels at a pixel density 4GB of RAM.', 'https://drive.google.com/uc?export=view&id=1_R8OKSxgCNB7gGUHyJFUDYBO-zosIYxq', 'huawei', 'Huawei 7', 360, 3),
        (NOW(), 'The G7 ThinQ hits the latest phone trends and includes signature LG features like a wide-angle camera and audiophile-quality sound for a solid alternative to flagships from Apple and Samsung.', 'https://drive.google.com/uc?export=view&id=1oEIxnoCaUOzHorZTOy_Fr2zKXgQKf1sE', 'lg', 'LG G7', 360, 4),
        (NOW(), 'The G6 ThinQ hits the latest phone trends and includes signature LG features like a wide-angle camera and audiophile-quality sound for a solid alternative to flagships from Apple and Samsung.', 'https://drive.google.com/uc?export=view&id=1h0dY-eVE0vFigNsAI5ZrBIIh91TEXava', 'lg', 'LG G6', 240, 4),
        (NOW(), 'The G4 ThinQ hits the latest phone trends and includes signature LG features like a wide-angle camera and audiophile-quality sound for a solid alternative to flagships from Apple and Samsung.', 'https://drive.google.com/uc?export=view&id=1h0dY-eVE0vFigNsAI5ZrBIIh91TEXava', 'lg', 'LG G4', 190, 4),
        (NOW(), 'The improved biometrics were sorely needed, and the camera is a leap forward, but the amazing low light capabilities have resulted in sacrifices elsewhere. ', 'https://drive.google.com/uc?export=view&id=1YhUMFv1SYKEz0FeZF-ZZSRNc_RgI56wM', 'samsung', 'samsung s9', 720, 5),
        (NOW(), 'The improved biometrics were sorely needed, and the camera is a leap forward, but the amazing low light capabilities have resulted in sacrifices elsewhere.', 'https://drive.google.com/uc?export=view&id=1vjIEyR3b7PGvQDRZ9muO53OheYwqc-8I', 'samsung', 'samsung s10', 920, 5),
        (NOW(), 'The improved biometrics were sorely needed, and the camera is a leap forward, but the amazing low light capabilities have resulted in sacrifices elsewhere. ', 'https://drive.google.com/uc?export=view&id=1YhUMFv1SYKEz0FeZF-ZZSRNc_RgI56wM', 'samsung', 'samsung s20', 1230, 5),
        (NOW(), 'The improved biometrics were sorely needed, and the camera is a leap forward, but the amazing low light capabilities have resulted in sacrifices elsewhere. ', 'https://drive.google.com/uc?export=view&id=1YhUMFv1SYKEz0FeZF-ZZSRNc_RgI56wM', 'samsung', 'samsung s8', 420, 5),
        (NOW(), 'The improved biometrics were sorely needed, and the camera is a leap forward, but the amazing low light capabilities have resulted in sacrifices elsewhere. ', 'https://drive.google.com/uc?export=view&id=1YhUMFv1SYKEz0FeZF-ZZSRNc_RgI56wM', 'samsung', 'samsung s7', 390, 5),
        (NOW(), 'The improved biometrics were sorely needed, and the camera is a leap forward, but the amazing low light capabilities have resulted in sacrifices elsewhere. ', 'https://drive.google.com/uc?export=view&id=1YhUMFv1SYKEz0FeZF-ZZSRNc_RgI56wM', 'samsung', 'samsung s6', 350, 5),
        (NOW(), 'Redmi Note 9 comes powered by MediaTek Helio G85 octa-core processor with a maximum frequency of 2.0GHz, a GPU frequency of 1000MHz, and up to 6GB of LPDDR4X RAM.', 'https://drive.google.com/uc?export=view&id=1srnC7ohGjT4dpQY9v8xODqmklOSNSocV', 'xiaomi', 'xiaomi redmi 9', 599, 6),
        (NOW(), 'Redmi Note 10 comes powered by MediaTek Helio G85 octa-core processor with a maximum frequency of 2.0GHz, a GPU frequency of 1000MHz, and up to 6GB of LPDDR4X RAM.', 'https://drive.google.com/uc?export=view&id=1srnC7ohGjT4dpQY9v8xODqmklOSNSocV', 'xiaomi', 'xiaomi redmi 10', 699, 6),
        (NOW(), 'Redmi Note 8 comes powered by MediaTek Helio G85 octa-core processor with a maximum frequency of 2.0GHz, a GPU frequency of 1000MHz, and up to 6GB of LPDDR4X RAM.', 'https://drive.google.com/uc?export=view&id=1srnC7ohGjT4dpQY9v8xODqmklOSNSocV', 'xiaomi', 'xiaomi redmi 8', 499, 6),
        (NOW(), 'Redmi Note 7 comes powered by MediaTek Helio G85 octa-core processor with a maximum frequency of 2.0GHz, a GPU frequency of 1000MHz, and up to 6GB of LPDDR4X RAM.', 'https://drive.google.com/uc?export=view&id=1srnC7ohGjT4dpQY9v8xODqmklOSNSocV', 'xiaomi', 'xiaomi redmi 7', 399, 6),
        (NOW(), 'Redmi Note 6 comes powered by MediaTek Helio G85 octa-core processor with a maximum frequency of 2.0GHz, a GPU frequency of 1000MHz, and up to 6GB of LPDDR4X RAM.', 'https://drive.google.com/uc?export=view&id=1srnC7ohGjT4dpQY9v8xODqmklOSNSocV', 'xiaomi', 'xiaomi redmi 6', 399, 6)


INSERT INTO address(firstname, lastname, address, city, zip, phone) VALUES('Kris', 'Pekla', 'Ilica 1', 'Zagreb', '10000', '0991234567'),
                            ('Pero', 'Peric', 'Ilica 2', 'Varaždin', '10000', '0991234567'),
                            ('Kris', 'Pekla', 'Ilica 1', 'Zagreb', '10000', '0991234567')

INSERT INTO public."order"(created, payment_type, total, user_id, address_id) VALUES(NOW(), 0, 1234, 1, 1)

INSERT INTO order_item(quantity, price, order_id, product_id) VALUES(3, 1700, 1, 4),
                                                                    (1, 640, 1, 3),
                                                                    (2, 1250, 1, 6)

