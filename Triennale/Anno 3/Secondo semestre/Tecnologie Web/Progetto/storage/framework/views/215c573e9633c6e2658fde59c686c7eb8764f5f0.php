<?php $__env->startSection('title', 'Inserimento nuova azienda'); ?>

<?php $__env->startSection('content'); ?>
    <div class="wrapper">
        <!-- box che contiene la form di login -->
        <div class="form-box form-box-inputdialog">
            <h2>Inserisci Azienda</h2>

            <!-- effettiva form di input -->
            <?php echo e(Form::open(array('url' => '/inserisciAziende', 'class' => 'contact-form', 'enctype' => 'multipart/form-data'))); ?>

            <div class="form-row">
                <div class="form-left">
                    <?php echo e(Form::label('nome', 'Nome', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('nome', '', ['class' => 'input', 'id' => 'nome', 'required' => 'required'])); ?>

                    <?php if($errors->first('nome')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('nome'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('descrizione', 'Descrizione', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::textarea('descrizione', '', ['class' => 'input', 'id' => 'descrizione', 'required' => 'required'])); ?>

                    <?php if($errors->first('descrizione')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('descrizione'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('ragioneSociale', 'Ragione Sociale', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('ragioneSociale', '',['class' => 'input', 'id' => 'ragioneSociale', 'required' => 'required'])); ?>

                    <?php if($errors->first('ragioneSociale')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('ragioneSociale'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>

                <div class="form-right">
                    <?php echo e(Form::label('tipologia', 'Tipologia', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('tipologia', '',['class' => 'input', 'id' => 'tipologia', 'required' => 'required'])); ?>

                    <?php if($errors->first('tipologia')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('tipologia'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('localizzazione', 'Dove si trova', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::textarea('localizzazione', '', ['class' => 'input', 'id' => 'tipologia', 'required' => 'required'])); ?>

                    <?php if($errors->first('localizzazione')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('localizazione'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('logo','Logo di questa azienda' )); ?>

                    <?php echo e(Form::file('logo', array('required' => 'required'))); ?>

                    <?php if($errors->first('logo')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('logo'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>
            </div>
            <?php echo e(Form::submit('Inserisci questa Azienda', ['class' => 'btn'])); ?>

            <?php echo e(Form::close()); ?>


            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('gestioneAziende')); ?>">Torna indietro</a>
            </div>
        </div>
    </div>
<?php $__env->stopSection(); ?>


<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/admin/inserisciAziende.blade.php ENDPATH**/ ?>